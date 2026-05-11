import java.util.*;

// Approach 1: Using Recursion

public static List<Integer> flattenRecurssion(List<?> nestedList) {
    List<Integer> result = new ArrayList<>();
    flattenHelper(nestedList, result);
    return result;
}

private static void flattenHelper(List<?> nestedList, List<Integer> result) {
    for (Object element : nestedList) {
        if (element instanceof Integer) {
            result.add((Integer) element);
        } else if (element instanceof List) {
            // Recursively flatten child list
            flattenHelper((List<?>) element, result);
        }
    }
}

// Approach 2: Using Stack

public class FlattenNestedList {

    public static List<Object> flatten(List<Object> nestedList) {
        List<Object> result = new ArrayList<>();
        Stack<Object> stack = new Stack<>();

        // Step 1: Push all items in reverse
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }

        // Step 2: Process until stack is empty
        while (!stack.isEmpty()) {
            Object current = stack.pop();

            if (current instanceof Integer) {
                // Direct number → add to result
                result.add(current);
            } else if (current instanceof List) {
                // It's a List → push elements in reverse order
                List<?> innerList = (List<?>) current;
                for (int i = innerList.size() - 1; i >= 0; i--) {
                    stack.push(innerList.get(i));
                }
            }
        }

        return result;
    }

    // Example usage
    public static void main(String[] args) {
        List<Object> nested = Arrays.asList(
                Arrays.asList(1),
                2,
                Arrays.asList(3, 4));

        System.out.println(flatten(nested)); // Output: [1, 2, 3, 4]\

        List<Object> nestedList = Arrays.asList(
                Arrays.asList(1),
                2,
                Arrays.asList(3, 4));

        List<Integer> flat = flattenRecurssion(nestedList);
        System.out.println(flat);
    }
}