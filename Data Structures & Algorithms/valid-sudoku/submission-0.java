class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean validation_1 = isRowColumnsValid(board);
        boolean validation_2 = isEvery3Valid(board);

        System.out.println(validation_1);
        System.out.println(validation_2);

        return validation_1 && validation_2;
    }

    public boolean isEvery3Valid(char[] [] board){
        for(int i = 0 ; i < 9 ; i += 3){
            for(int j = 0 ; j < 9 ; j += 3){
                HashSet <Integer> set = new HashSet <Integer> ();
                for(int k = i ; k < i+3 ; k++){
                    for(int l = j ; l < j+3; l++){
                        char ch = board[k][l];
                        if(ch == '.') continue;
                        int ch_int = Character.getNumericValue(ch);
                        if(set.contains(ch_int)) return false;
                        set.add(ch_int);
                    }
                }
            }
        }

        return true;
    }

    public boolean isRowColumnsValid(char [] [] board){
        List <HashSet<Integer>> columnsTracker = new ArrayList <HashSet<Integer>> ();

        for(int i = 0 ; i < 9 ; i++) columnsTracker.add(new HashSet <Integer> ());

        for(int i = 0 ; i < 9 ; i++){
            HashSet <Integer> currentRowTracker = new HashSet <> ();
            for(int j = 0 ; j < 9 ; j++){
                char ch = board[i][j];
                if(ch == '.') continue;

                int ch_int = Character.getNumericValue(ch);
                if(currentRowTracker.contains(ch_int)) return false;
                currentRowTracker.add(ch_int);

                if(columnsTracker.get(j).contains(ch_int)) return false;
                columnsTracker.get(j).add(ch_int);
            }
        }


        return true;
    }
}
