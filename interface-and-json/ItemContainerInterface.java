import java.util.Collection;

public interface ItemContainerInterface extends Iterable<Item>
{
    public void add(Item item);

    public Item take(String name);

    public String inventory(String prefix, String infix);

    public int size();
    
    /** 
     * this is needed for the deserialization
     */
    public void setItems(Collection<Item> items);
    

}
