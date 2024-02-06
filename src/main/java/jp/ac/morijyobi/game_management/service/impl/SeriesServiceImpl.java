package jp.ac.morijyobi.game_management.service.impl;

import jp.ac.morijyobi.game_management.bean.entity.Series;
import jp.ac.morijyobi.game_management.bean.form.SeriesForm;
import jp.ac.morijyobi.game_management.mapper.SeriesMapper;
import jp.ac.morijyobi.game_management.service.SeriesService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeriesServiceImpl implements SeriesService {
    private final SeriesMapper seriesMapper;

    public SeriesServiceImpl(SeriesMapper seriesMapper) {
        this.seriesMapper = seriesMapper;
    }
    @Override
    public Series registerSeries(SeriesForm seriesForm) {
        Series series = new Series();
        series.setSeriesName(seriesForm.getSeriesName());

        seriesMapper.insertSeries(series);
        return null;
    }

    @Override
    public List<Series> getAllSeries() {
        return seriesMapper.selectAllSeries();
    }
}
