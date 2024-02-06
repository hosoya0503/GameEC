package jp.ac.morijyobi.game_management.service;

import jp.ac.morijyobi.game_management.bean.entity.Series;
import jp.ac.morijyobi.game_management.bean.form.SeriesForm;

import java.util.List;

public interface SeriesService {
    Series registerSeries(SeriesForm seriesForm);
    List<Series> getAllSeries();
}
