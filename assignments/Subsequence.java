import java.util.ArrayList;
import java.util.List;

public class Subsequence {
    
    public static void main(String[] args) {
        int[] arr = {10, 9, 2, 5, 3, 7, 101, 18};
        
        System.out.println(lengthOfLIS(arr));
    }

    public static int lengthOfLIS(int[] nums) {
        ArrayList<Integer> sequence = new ArrayList<>();
        // Convert nums array into an ArrayList to make life easier
        for(int i = 0; i < nums.length; i++) {
            sequence.add(nums[i]);
        }

        return subsequence(new ArrayList(), sequence);
    }

    public static int subsequence(List<Integer> seq, List<Integer> nums) {
        // If there are no more numbers, return what we've got
        if((nums.isEmpty())) {
            return seq.size();
        // If the next number is less than or equal to our last inserted number, return what we've got
        } else if(!seq.isEmpty() && nums.get(0) <= seq.get(seq.size() - 1)) {
            return seq.size();
        }

        ArrayList<Integer> seq1 = new ArrayList<>(seq);
        ArrayList<Integer> seq2 = new ArrayList<>(seq);
        seq2.add(nums.get(0));

        // Recurse off into a path where we don't add the element, and one where we do, return the higher of the two
        return Math.max(subsequence(seq1, nums.subList(1, nums.size())), subsequence(seq2, nums.subList(1, nums.size())));
    }
}
