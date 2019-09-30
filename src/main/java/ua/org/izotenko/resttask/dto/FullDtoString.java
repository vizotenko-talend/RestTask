package ua.org.izotenko.resttask.dto;

public class FullDtoString {

    private String string;

    private Integer longestWordInt;

    private String longestWord;

    public FullDtoString(String string, String longestWord, Integer longestWordInt) {
        this.string = string;
        this.longestWord = longestWord;
        this.longestWordInt = longestWordInt;
    }

    public String getString() {
        return string;
    }

    public String getLongestWord() {
        return longestWord;
    }

    public Integer getLongestWordInt() {
        return longestWordInt;
    }

}
