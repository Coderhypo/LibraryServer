package net.ihypo.models;

/**
 * 图书类型类，与数据库中book_type表对应
 * Created by hypo on 15-12-26.
 */
public class BookType {

    private Integer typeId;
    private String typeCode;
    private String typeName;

    public BookType(String typeCode, String typeName) {
        this.typeCode = typeCode;
        this.typeName = typeName;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
