package ua.org.izotenko.resttask.service;

import ua.org.izotenko.resttask.dto.DtoString;

import java.util.List;

public interface Selector {
    List<DtoString> selectAndSortStrings(List<String> list);
}
