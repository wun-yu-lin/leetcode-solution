class RandomizedSet {
    //key: val, value: indexToList
    private final Map<Integer, Integer> valToIndexMap;

    private final List<Integer> listVal;

    private final Random random;

    public RandomizedSet() {
        valToIndexMap = new HashMap<>();
        listVal = new ArrayList<>();
        random  = new Random();
    }

    public boolean insert(int val) {
        if (valToIndexMap.containsKey(val)){
            return false;
        }
        listVal.add(val); //add last element
        //put val and index of last element of list
        valToIndexMap.put(val, listVal.size()-1);
        return true;
    }

    public boolean remove(int val) {
        if (!valToIndexMap.containsKey(val)){
            return false;
        }
        int indexOfVal = valToIndexMap.get(val);
        int lastElement = listVal.get(listVal.size()-1);
        //swap last element & remove target val in list
        listVal.set(indexOfVal, lastElement);
        //update lastElement in map
        valToIndexMap.put(lastElement, indexOfVal);
        //移除最後一個 element 不會造成 arrayCopy
        listVal.remove(listVal.size()-1);
        valToIndexMap.remove(val);
        return true;
    }

    public int getRandom() {
        //這邊需要考慮到 list 是空的情境，我認為題目設計有瑕疵，因為介面開好了 int , 我無法修改
        return listVal.get(random.nextInt(listVal.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */