package com.iooc.agv.mapper;

import java.util.List;

public interface RecordMapper {
    List queryTaskRecord(Object obj);

    List queryAbnormalRecord(Object obj);
}
