package com.krapinem.sqlite;

public class Students {
    int _id;
    String _name;

    public Students() {
    }

    public Students(String name) {
        this._name = name;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }
}
