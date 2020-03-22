package org.nmefc.tsunmai.entity;

import javax.persistence.*;
import java.awt.*;
import java.util.Objects;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: evase
 * \* Date: 2020/3/22
 * \* Time: 18:00
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@Entity
@Table(name = "station_info", schema = "tsunami", catalog = "")
public class StationInfoEntity {
    private long id;
    private Point point;
    private String remark;
    private String desc;
    private Integer area;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    //    @Basic
    @Column(name = "point", columnDefinition = "POINT")
    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    @Basic
    @Column(name = "remark")
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Basic
    @Column(name = "desc")
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Basic
    @Column(name = "area")
    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StationInfoEntity that = (StationInfoEntity) o;
        return id == that.id &&
                Objects.equals(point, that.point) &&
                Objects.equals(remark, that.remark) &&
                Objects.equals(desc, that.desc) &&
                Objects.equals(area, that.area);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, point, remark, desc, area);
    }
}
