import java.util.Arrays;
import java.util.Comparator;

public class CustomerPriorityComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        Customer c1 = (Customer) o1;
        Customer c2 = (Customer) o2;
        CreditHistory h1 = c1.getCreditHistory();
        CreditHistory h2 = c2.getCreditHistory();
        boolean nonNullHistory = h1!=null && h2!=null;

       if(nonNullHistory && h1.getCreditRating()>h2.getCreditRating()){
            return -1;
        }else if(nonNullHistory && h1.getCreditRating()<h2.getCreditRating()){
            return 1;
        }else if(!c1.getName().equals(c2)){
            char[] myName = c1.getName().toCharArray();
            char[] otherName = c2.getName().toCharArray();
            for(int i=0;i<myName.length && i<otherName.length;i++){
                if(Character.toLowerCase(myName[i])<Character.toLowerCase(otherName[i])) return -1;
                if(Character.toLowerCase(myName[i])>Character.toLowerCase(otherName[i])) return 1;
            }
        }

        return 0;
    }


}
