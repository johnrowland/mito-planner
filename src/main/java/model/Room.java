package model;

import java.util.Objects;

/**
 * A room on the 4th floor. Includes both offices and lab rooms.
 */
public class Room {
    private final int mId;
    private final String mRoomName;
    private final int mCapacity;

    Room(int id, String name, int capacity) {
        mId = id;
        mRoomName = name;
        mCapacity = capacity;
    }

    public int getId() {
        return mId;
    }

    public String getRoomName() {
        return mRoomName;
    }

    public int getCapacity() {
        return mCapacity;
    }


    // equals and hashCode are simply based on the id.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return mId == room.mId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(mId);
    }

    @Override
    public String toString() {
        return "Room{" +
                "mId=" + mId +
                ", mRoomName='" + mRoomName + '\'' +
                ", mCapacity=" + mCapacity +
                '}';
    }
}
