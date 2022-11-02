package pl.piomin.samples.spring.graphql.domain;

import graphql.schema.*;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Component
public class DateScalarType extends GraphQLScalarType {
    public DateScalarType() {
        super("Date", "Date TIME", new Coercing() {
            @Override
            public Object serialize(Object o) throws CoercingSerializeException {
//                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX", Locale.ENGLISH);
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.ENGLISH);


                return formatter.format((Date) o);
            }

            @Override
            public Object parseValue(Object o) throws CoercingParseValueException {
                return o;
            }

            @Override
            public Object parseLiteral(Object o) throws CoercingParseLiteralException {
                if (o == null) {
                    return null;
                }
                return o.toString();
            }
        });
    }
}