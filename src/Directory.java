import java.util.Collection;

/**
 * Created by jack on 3/31/17.
 */
public class Directory {
    Collection<Person> people;
    Collection<Facility> facilities;
    Collection<Department> departments;
    Collection<Location> locations;

    public Directory(Collection<Person> people, Collection<Facility> facilities,
                     Collection<Department> departments, Collection<Location> locations){
        this.people = people;
        this.facilities = facilities;
        this.departments = departments;
        this.locations = locations;
    }

    public void search(){}
}
