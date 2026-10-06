package com.app.maria.domain.targetproduct.mapper;

import com.app.maria.domain.targetproduct.dto.TargetProductJudgementDTO;
import com.app.maria.domain.targetproduct.dto.TargetProductJudgementFailureDTO;
import com.app.maria.domain.targetproduct.dto.TargetProductJudgementListDTO;
import com.app.maria.domain.targetproduct.dto.TargetProductSearchDTO;
import com.app.maria.domain.targetproduct.dto.TargetProductSummaryDTO;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TargetProductMapper {

    void insertJudgement(TargetProductJudgementDTO judgementDTO);

    boolean existsByMydataTradeId(Long mydataTradeId);

    Optional<TargetProductJudgementFailureDTO> selectFailureByMydataTradeId(Long mydataTradeId);

    void upsertFailure(TargetProductJudgementFailureDTO failureDTO);

    List<TargetProductJudgementListDTO> selectJudgements(TargetProductSearchDTO searchDTO);

    int countJudgements();

    int countFilteredJudgements(TargetProductSearchDTO searchDTO);

    TargetProductSummaryDTO selectSummary(
            @Param("today") LocalDate today, @Param("tomorrow") LocalDate tomorrow);

    void deleteFailureByMydataTradeId(Long mydataTradeId);
}
