package com.mvvm.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Auth implements Parcelable {

    String first_name;
    String last_name;
    String email;
    String password;
    String retype_password;
    String gender;
    String country;
    boolean status;

    protected Auth(Parcel in) {
        first_name = in.readString();
        last_name = in.readString();
        email = in.readString();
        password = in.readString();
        retype_password = in.readString();
        gender = in.readString();
        country = in.readString();
        status = in.readByte() != 0;
    }

    public static final Creator<Auth> CREATOR = new Creator<Auth>() {
        @Override
        public Auth createFromParcel(Parcel in) {
            return new Auth(in);
        }

        @Override
        public Auth[] newArray(int size) {
            return new Auth[size];
        }
    };

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Auth() {
    }

    public Auth(String first_name, String last_name, String email, String password, String retype_password, String gender, String country) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
        this.retype_password = retype_password;
        this.gender = gender;
        this.country = country;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRetype_password() {
        return retype_password;
    }

    public void setRetype_password(String retype_password) {
        this.retype_password = retype_password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(first_name);
        dest.writeString(last_name);
        dest.writeString(email);
        dest.writeString(password);
        dest.writeString(retype_password);
        dest.writeString(gender);
        dest.writeString(country);
        dest.writeByte((byte) (status ? 1 : 0));
    }
}
