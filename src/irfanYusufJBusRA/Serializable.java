package irfanYusufJBusRA;
import java.util.HashMap;

public class Serializable {
    public final int id;
    private static HashMap<Class<?>, Integer> mapCounter = new HashMap<>();
    Class<?> currentClass = this.getClass();

    protected Serializable()
    {
        Class<?> className = this.getClass();
        int lastId = getLastAssignedId(className);
        this.id = lastId + 1;
        mapCounter.put(className, this.id);
    }

    public static Integer getLastAssignedId(Class<?> className){
        return mapCounter.getOrDefault(className,0);
    }

    public static Integer setLastAssignedId(Class <?> className, int nilai) {
        mapCounter.put(className, nilai);
        return nilai;
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
