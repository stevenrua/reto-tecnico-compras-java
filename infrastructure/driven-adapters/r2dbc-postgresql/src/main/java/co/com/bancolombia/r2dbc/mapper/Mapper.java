package co.com.bancolombia.r2dbc.mapper;

import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class Mapper {

    static ModelMapper modelMapper = new ModelMapper();

    public static <S, T> T map(S source, Class<T> targetClass) {
        return modelMapper.map(source, targetClass);
    }

    public static <S, T> List<T> mapAll(List<S> source, Class<T> targetClass) {
        List<T> list = new ArrayList<>();
        for(S s : source) {
            list.add(modelMapper.map(s, targetClass));
        }
        return list;
    }

}
