package ua.org.izotenko.resttask.controller;

import ua.org.izotenko.resttask.dto.DtoString;
import ua.org.izotenko.resttask.service.Selector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/strings")
public class StringsController {

    public static final String RESULT = "result";
    public static final String STRINGS_FOR_SORTING = "strings";

    @Autowired
    private Selector selector;

    @PostMapping(path = "/sortByLongestWord")
    public Map<String, List<DtoString>> sortStringsByLongestWord(@RequestBody  Map<String, List<String>> payload){
        Map<String, List<DtoString>> map = new HashMap<>();
        map.put(RESULT, selector.selectAndSortStrings(payload.get(STRINGS_FOR_SORTING)));
        return map;
    }

}
