package com.irfanYusufJBusRA.dbjson;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.irfanYusufJBusRA.dbjson.Serializable;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Collections;
import java.util.Vector;

/**
 * Json Table is used to write and read JSON in every class or method that call json table
 * @param <T> generic as a universal type of data.
 * @author Rafie Amandio
 */
public class JsonTable<T> extends Vector<T> {
    private static final Gson gson = new Gson();
    public final String filepath;

    @SuppressWarnings("unchecked")
    public JsonTable(Class<T> clazz, String filepath) throws IOException {
        this.filepath = filepath;
        try {
            Class<T[]> arrayType = (Class<T[]>) Array.newInstance(clazz, 0).getClass();
            T[] loaded = readJson(arrayType, filepath);
            if (loaded != null) {
                Collections.addAll(this, loaded);

                int lastId = 0;
                for (T item : this) {
                    if (item instanceof com.irfanYusufJBusRA.dbjson.Serializable) {

                        com.irfanYusufJBusRA.dbjson.Serializable serializableItem = (com.irfanYusufJBusRA.dbjson.Serializable) item;
                        lastId = Math.max(lastId, serializableItem.id);
                    }
                }

                Serializable.setLastAssignedId(clazz, lastId);
            }
        } catch (FileNotFoundException e) {
            File file = new File(filepath);
            File parent = file.getParentFile();
            if (parent != null)
                parent.mkdirs();
            file.createNewFile();
        }
    }


    public void writeJson() throws IOException
    {
        writeJson(this, this.filepath);
    }

    public static void writeJson(Object object, String filepath) throws IOException
    {
        final FileWriter writer = new FileWriter(filepath);
        writer.write(gson.toJson(object));
        writer.close();
    }

    public static <T> T readJson(Class<T> clazz, String filepath) throws FileNotFoundException
    {
        final JsonReader reader = new JsonReader(new FileReader(filepath));
        return gson.fromJson(reader, clazz);
    }
}
