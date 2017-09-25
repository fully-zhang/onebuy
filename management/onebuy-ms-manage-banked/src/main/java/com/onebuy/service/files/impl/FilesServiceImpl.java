package com.onebuy.service.files.impl;

import com.onebuy.domain.BaseEntity;
import com.onebuy.service.files.FilesService;
import com.univocity.parsers.common.processor.BeanListProcessor;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;

import java.io.File;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by zhj on 2017/9/22 0022.
 */
public class FilesServiceImpl<D extends BaseEntity> implements FilesService<D>{

    @Override
    public List<D> queryLoansInCSV(File file) {
        Class <D> entityClass = (Class <D>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        BeanListProcessor<D> rowProcessor = new BeanListProcessor(entityClass);
        CsvParserSettings parserSettings = new CsvParserSettings();
        parserSettings.setRowProcessor(rowProcessor);
        parserSettings.setHeaderExtractionEnabled(true);

        CsvParser parser = new CsvParser(parserSettings);
        parser.parse(file,"UTF-8");
        List<D> dList = rowProcessor.getBeans();
        return dList;
    }

}
