class Solution {
    public int[] singleNumber(int[] nums) {
        ArrayList<Integer> list=new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int num : nums) {
            if (map.get(num) != 2) {
                list.add(num);
            }
        }
        int[] arr = list.stream().mapToInt(Integer::intValue).toArray();

        return arr;
        }
}