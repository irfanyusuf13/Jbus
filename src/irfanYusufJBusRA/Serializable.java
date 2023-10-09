package irfanYusufJBusRA;
import java.util.HashMap;

public class Serializable {
    public final int id;
    private static HashMap<Class<?>, Integer> mapCounter = new HashMap<>();
    Class<?> currentClass = this.getClass();

    protected Serializable()
    {

        if (mapCounter == null){
            mapCounter = new HashMap<Class<?>, Integer>();
            this.id = 0;
        }
        else {
            int counter = mapCounter.getOrDefault(this.getClass(), 0);
            mapCounter.put(this.getClass(), counter++);
            this.id = counter;
        }
    }

    public static Integer getLastAssignedId(Class<?> className){
        return mapCounter.getOrDefault(className,0);
    }

    public static Integer setLastAssignedId(Class <?> className, int nilai) {
        mapCounter.put(className, nilai);
        return mapCounter.replace(className, nilai);
    }

    public boolean equals(Serializable obj) {
        return this.id == obj.id;
    }

    public int compareTo(Serializable obj) {
        if (id == obj.id){
            return 0;
        }
        else if (id > obj.id) {
            return 1;
        }
        else{
            return -1;
        }

    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Serializable other = (Serializable) obj;
        return this.id == other.id;

    }
}
