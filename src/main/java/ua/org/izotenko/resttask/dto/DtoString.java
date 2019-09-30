package ua.org.izotenko.resttask.dto;

public class DtoString {

    private String string;

    private Integer longestWord;


    public DtoString(String string, Integer longestWord) {
        this.string = string;
        this.longestWord = longestWord;
    }

    public String getString() {
        return string;
    }


    public Integer getLongestWord() {
        return longestWord;
    }

}
