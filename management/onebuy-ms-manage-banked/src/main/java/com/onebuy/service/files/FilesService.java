package com.onebuy.service.files;

import com.onebuy.domain.BaseEntity;

import java.io.File;
import java.util.List;

/**
 * Created by zhj on 2017/9/22 0022.
 */
public interface FilesService<D extends BaseEntity> {

    List<D> queryLoansInCSV(File file);

}
