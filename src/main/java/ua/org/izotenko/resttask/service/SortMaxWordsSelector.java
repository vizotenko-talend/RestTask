package ua.org.izotenko.resttask.service;

import ua.org.izotenko.resttask.dto.DtoString;
import ua.org.izotenko.resttask.dto.FullDtoString;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SortMaxWordsSelector implements Selector {

    @Override
    public List<DtoString> selectAndSortStrings(List<String> list) {
        return list.stream().map(string -> {
            String longestWord = Arrays.stream(string.split(" ")).max(Comparator.comparingInt(String::length).thenComparing(String::toString)).orElse("");
            return new FullDtoString(string, longestWord, longestWord.length());
        }).sorted(Comparator.comparingInt(FullDtoString::getLongestWordInt).thenComparing(FullDtoString::getLongestWord).reversed()).limit(5).map(string -> {
            return new DtoString(string.getString(), string.getLongestWordInt());
        }).collect(Collectors.toList());
    }
}
