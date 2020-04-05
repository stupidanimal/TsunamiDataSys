package org.nmefc.tsunmai.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.hibernate.annotations.Type;
// TODO:[*] 此处参考:http://www.hibernatespatial.org/documentation/02-Tutorial/01-tutorial4/
import com.vividsolutions.jts.geom.Point;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
// TODO:[-] 解决 geo 类型序列化时出现的无限循环问题 此处参考:https://stackoverflow.com/questions/45713934/jackson-deserialize-geojson-point-in-spring-boot
import com.bedatadriven.jackson.datatype.jts.serialization.GeometryDeserializer;
import com.bedatadriven.jackson.datatype.jts.serialization.GeometrySerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.vividsolutions.jts.geom.Geometry;


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

    @JsonSerialize(using = GeometrySerializer.class)
//    @JsonSerialize(contentUsing = GeometryDeserializer.class)
    @Type(type = "org.hibernate.spatial.GeometryType")
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
//    @Type(type = "com.iheartcity.apiapp.geometry.MySQLGeometryType")
    @Column(name = "point", columnDefinition = "geometry(Point,0)")
    //@Column(name="point")
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
