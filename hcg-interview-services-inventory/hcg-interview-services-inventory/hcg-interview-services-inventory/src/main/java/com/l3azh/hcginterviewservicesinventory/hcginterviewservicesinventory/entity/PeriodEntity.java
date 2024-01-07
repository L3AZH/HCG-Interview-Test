package com.l3azh.hcginterviewservicesinventory.hcginterviewservicesinventory.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = EntityConstant.Period.PERIOD_TABLE_NAME)
@Getter
@Setter
public class PeriodEntity {
    @Id
    private Integer id;
    @Column(name = EntityConstant.Period.START_DATE_COLUMN)
    private Date startDate;
    @Column(name = EntityConstant.Period.END_DATE_COLUMN)
    private Date endDate;
    @ManyToMany
    @JoinTable(
            name = EntityConstant.RelationshipPeriodAndRatePlan.TABLE_NAME,
            joinColumns = @JoinColumn(name = EntityConstant.RelationshipPeriodAndRatePlan.PERIOD_ID_COLUMN),
            inverseJoinColumns = @JoinColumn(name = EntityConstant.RelationshipPeriodAndRatePlan.RATE_PLAN_ID_COLUMN))
    private List<RatePlanEntity> ratePlanEntityList;
}
