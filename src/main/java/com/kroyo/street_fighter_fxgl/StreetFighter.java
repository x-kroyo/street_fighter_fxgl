package com.kroyo.street_fighter_fxgl;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;

public class StreetFighter extends GameApplication {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    protected void initSettings(GameSettings gameSettings) {
        ApplicationContext context = new ClassPathXmlApplicationContext("settings.xml");
        GameSettings defaultSettings = (GameSettings) context.getBean("defaultSettings");

        try {
            PropertyDescriptor[] descriptors = Introspector
                    .getBeanInfo(GameSettings.class)
                    .getPropertyDescriptors();
            for (PropertyDescriptor pd : descriptors) {
                if (pd.getReadMethod() == null || pd.getWriteMethod() == null) {
                    continue;
                }
                Object value = pd.getReadMethod().invoke(defaultSettings);
                pd.getWriteMethod().invoke(gameSettings, value);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

}