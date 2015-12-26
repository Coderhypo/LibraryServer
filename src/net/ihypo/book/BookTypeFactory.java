package net.ihypo.book;

import net.ihypo.database.BookTypeDAO;
import net.ihypo.database.IDAO;
import net.ihypo.models.BookType;

/**
 * 图书类型工厂类 生产图书类型 并持久化
 * Created by hypo on 15-12-27.
 */
public class BookTypeFactory {
    private String typeCode;
    private String typeName;

    public BookTypeFactory(String typeCode, String typeName) {
        setTypeCode(typeCode);
        setTypeName(typeName);
    }

    public BookType getNewType(){
        BookType type = new BookType(typeCode,typeName);

        //数据持久化
        IDAO dao = new BookTypeDAO();
        dao.add(type);

        return type;
    }

    private void setTypeCode(String typeCode) {
        this.typeCode = typeCode.substring(0,10);
    }

    private void setTypeName(String typeName) {
        this.typeName = typeName.substring(0,20);
    }
}
