class MyCalendar {
    List<List<Integer>> list; 
    public MyCalendar() {
        list = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        if(list.isEmpty()){
            list.add(Arrays.asList(start,end));
            return true;
        }
        
        for(List<Integer> lt : list){
            if(lt.get(0) < end && start < lt.get(1)) return false;
        }
        list.add(Arrays.asList(start,end));
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
