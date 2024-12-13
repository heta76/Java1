package org.knit.lab9.task17;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class Validator {
    public static void validate(Object obj) throws IllegalAccessException {
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            //разрешает доступ к private переменным
            field.setAccessible(true);
            Object value = field.get(obj);

            // Проверка @NotNull
            if (field.isAnnotationPresent(NotNull.class) && value == null) {
                System.out.println("Поле " + field.getName() + " не должно быть null.");
            }

            // Проверка @MaxLength
            if (field.isAnnotationPresent(MaxLength.class)) {
                int maxLength = field.getAnnotation(MaxLength.class).value();
                if (value instanceof String) {
                    String stringValue = (String) value;
                    if (stringValue != null && maxLength < stringValue.length()) {
                        System.out.println("Длина поля " + field.getName() + " должна быть не больше " + maxLength);
                    }
                }
            }

            // Проверка @Min
            if (field.isAnnotationPresent(Min.class)) {
                try {
                    int min = field.getAnnotation(Min.class).value();
                    int intValue = (int)value;
                    if (min > intValue) {
                        System.out.println("Поле " + field.getName() + " должно быть не меньше " + min);
                    }
                } catch (Exception e) {
                    System.out.println("Неверный возраст");
                }
            }
        }
    }
}