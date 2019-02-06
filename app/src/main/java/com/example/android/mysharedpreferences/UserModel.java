package com.example.android.mysharedpreferences;

import android.os.Parcel;
import android.os.Parcelable;

public class UserModel implements Parcelable {
    String name, email, phoneNumber;
    int age;
    boolean isLove;

    public UserModel() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isLove() {
        return isLove;
    }

    public void setLove(boolean love) {
        isLove = love;
    }

    protected UserModel(Parcel in) {
        this.name = in.readString();
        this.email = in.readString();
        this.phoneNumber = in.readString();
        this.age = in.readInt();
        this.isLove = in.readByte() != 0;
    }

    public static final Creator<UserModel> CREATOR = new Creator<UserModel>() {
        @Override
        public UserModel createFromParcel(Parcel in) {
            return new UserModel(in);
        }

        @Override
        public UserModel[] newArray(int size) {
            return new UserModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeString(this.email);
        parcel.writeString(this.phoneNumber);
        parcel.writeInt(this.age);
        parcel.writeByte(this.isLove ? (byte) 1 : (byte) 0);
    }
}
