package com.sample.model.creational.builder;
import java.util.ArrayList;

import java.util.List;



class HashMapCodeBuilder {

    protected String className;

    protected List<Field> fields = new ArrayList<>();



    public HashMapCodeBuilder(String className) {

        this.className = className;

    }



    public HashMapCodeBuilder addField(String name, String type) {

        this.fields.add(new Field(name, type));

        return this;

    }



    @Override

    public String toString() {

        StringBuilder sb = new StringBuilder(String.format("public class %s\n", this.className));

        sb.append("{\n");

        for (Field field : this.fields) {

            sb.append(String.format("  public %s %s;\n", field.type, field.name));

        }

        sb.append("}");

        return sb.toString();

    }
    
       private class Field {

        public String name;

        public String type;



        public Field(String name, String type) {

            this.name = name;

            this.type = type;

        }

    }
}