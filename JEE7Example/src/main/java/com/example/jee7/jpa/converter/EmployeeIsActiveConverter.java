package com.example.jee7.jpa.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 *
 * @author David EXCOFFIER david.excoffier@st.com
 */
@Converter(autoApply = false) 
public class EmployeeIsActiveConverter implements AttributeConverter<Boolean, String> {

    @Override
    public String convertToDatabaseColumn(Boolean attribute) {
        if (attribute) {
            return "T";
        }
        return "F";
    }

    @Override
    public Boolean convertToEntityAttribute(String dbData) {
        return "T".equals(dbData);
    }

}
