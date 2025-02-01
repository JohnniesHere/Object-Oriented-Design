import java.util.Iterator;

public class GroupTester {
    private static int testsPassed = 0;
    private static int totalTests = 0;

    public static void main(String[] args) {
        System.out.println("Starting comprehensive Group class testing...\n");

        // Test basic operations
        testBasicOperations();

        // Test edge cases
        testEdgeCases();

        // Test iterator
        testIterator();

        // Test set operations
        testSetOperations();

        // Test complex scenarios
        testComplexScenarios();

        // Print final results
        System.out.println("\nFinal Results:");
        System.out.println("Tests Passed: " + testsPassed);
        System.out.println("Total Tests: " + totalTests);
        System.out.println("Success Rate: " + (testsPassed * 100.0 / totalTests) + "%");
    }

    private static void assertTest(String testName, boolean condition) {
        totalTests++;
        if (condition) {
            testsPassed++;
            System.out.println("✓ " + testName + " - PASSED");
        } else {
            System.out.println("✗ " + testName + " - FAILED");
        }
    }

    private static void testBasicOperations() {
        System.out.println("\n=== Testing Basic Operations ===");

        Group group = new Group();

        // Test add
        assertTest("Add first element", group.add(5));
        assertTest("Add second element", group.add(10));
        assertTest("Add duplicate element", !group.add(5));

        // Test search
        assertTest("Search existing element", group.search(5));
        assertTest("Search non-existing element", !group.search(7));

        // Test containsElement
        assertTest("Contains existing element", group.containsElement(10));
        assertTest("Contains non-existing element", !group.containsElement(15));

        // Test remove
        assertTest("Remove existing element", group.remove(5));
        assertTest("Remove non-existing element", !group.remove(7));
        assertTest("Verify removed element", !group.search(5));
    }

    private static void testEdgeCases() {
        System.out.println("\n=== Testing Edge Cases ===");

        Group group = new Group();

        // Test operations on empty group
        assertTest("Remove from empty group", !group.remove(5));
        assertTest("Search in empty group", !group.search(5));
        assertTest("Contains in empty group", !group.containsElement(5));

        // Test with Integer.MAX_VALUE and Integer.MIN_VALUE
        assertTest("Add MAX_VALUE", group.add(Integer.MAX_VALUE));
        assertTest("Add MIN_VALUE", group.add(Integer.MIN_VALUE));
        assertTest("Search MAX_VALUE", group.search(Integer.MAX_VALUE));
        assertTest("Search MIN_VALUE", group.search(Integer.MIN_VALUE));

        // Test removing all elements
        assertTest("Remove MAX_VALUE", group.remove(Integer.MAX_VALUE));
        assertTest("Remove MIN_VALUE", group.remove(Integer.MIN_VALUE));
        assertTest("Group should be empty", !group.iterator().hasNext());
    }

    private static void testIterator() {
        System.out.println("\n=== Testing Iterator ===");

        Group group = new Group();
        int[] elements = {1, 2, 3, 4, 5};

        // Add elements
        for (int element : elements) {
            group.add(element);
        }

        // Test iterator functionality
        Iterator<Integer> iterator = group.iterator();
        boolean hasAllElements = true;
        int count = 0;

        while (iterator.hasNext()) {
            int element = iterator.next();
            boolean found = false;
            for (int expectedElement : elements) {
                if (element == expectedElement) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                hasAllElements = false;
            }
            count++;
        }

        assertTest("Iterator contains all elements", hasAllElements);
        assertTest("Iterator count matches", count == elements.length);

        // Test iterator on empty group
        Group emptyGroup = new Group();
        assertTest("Empty group iterator hasNext", !emptyGroup.iterator().hasNext());

        // Test for-each loop
        count = 0;
        for (int element : group) {
            count++;
        }
        assertTest("For-each loop count matches", count == elements.length);
    }

    private static void testSetOperations() {
        System.out.println("\n=== Testing Set Operations ===");

        Group group1 = new Group();
        Group group2 = new Group();

        // Prepare test groups
        group1.add(1); group1.add(2); group1.add(3);
        group2.add(2); group2.add(3); group2.add(4);

        // Test intersection
        Group intersection = group1.intersection(group2);
        assertTest("Intersection size check", countElements(intersection) == 2);
        assertTest("Intersection contains common element 2", intersection.containsElement(2));
        assertTest("Intersection contains common element 3", intersection.containsElement(3));
        assertTest("Intersection doesn't contain non-common element", !intersection.containsElement(1));

        // Test union
        Group union = group1.union(group2);
        assertTest("Union size check", countElements(union) == 4);
        assertTest("Union contains all elements",
            union.containsElement(1) && union.containsElement(2) &&
            union.containsElement(3) && union.containsElement(4));

        // Test operations with empty group
        Group emptyGroup = new Group();
        Group intersectWithEmpty = group1.intersection(emptyGroup);
        assertTest("Intersection with empty group", countElements(intersectWithEmpty) == 0);

        Group unionWithEmpty = group1.union(emptyGroup);
        assertTest("Union with empty group", countElements(unionWithEmpty) == countElements(group1));
    }

    private static void testComplexScenarios() {
        System.out.println("\n=== Testing Complex Scenarios ===");

        Group group = new Group();

        // Test adding and removing alternately
        assertTest("Add first", group.add(1));
        assertTest("Remove first", group.remove(1));
        assertTest("Add again", group.add(1));
        assertTest("Element exists after re-adding", group.containsElement(1));

        // Test multiple operations sequence
        Group group1 = new Group();
        Group group2 = new Group();

        // Build groups
        for (int i = 0; i < 100; i++) {
            group1.add(i);
            group2.add(i * 2);
        }

        // Test large intersection
        Group largeIntersection = group1.intersection(group2);
        assertTest("Large intersection size", countElements(largeIntersection) == 50);

        // Test large union
        Group largeUnion = group1.union(group2);
        assertTest("Large union size", countElements(largeUnion) == 150);

        // Test adding elements after set operations
        Group resultGroup = group1.intersection(group2);
        assertTest("Add to result group", resultGroup.add(1000));
        assertTest("New element exists in result group", resultGroup.containsElement(1000));

        // Test chained operations
        Group chainedResult = group1.intersection(group2).union(new Group());
        assertTest("Chained operations result", countElements(chainedResult) == countElements(largeIntersection));
    }

    private static int countElements(Group group) {
        int count = 0;
        for (int element : group) {
            count++;
        }
        return count;
    }
}