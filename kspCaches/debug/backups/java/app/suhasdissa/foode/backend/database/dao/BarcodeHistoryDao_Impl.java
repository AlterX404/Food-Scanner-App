package app.suhasdissa.foode.backend.database.dao;

import android.database.Cursor;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import app.suhasdissa.foode.backend.database.entities.BarcodeEntity;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class BarcodeHistoryDao_Impl implements BarcodeHistoryDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<BarcodeEntity> __insertionAdapterOfBarcodeEntity;

  private final EntityDeletionOrUpdateAdapter<BarcodeEntity> __deletionAdapterOfBarcodeEntity;

  public BarcodeHistoryDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfBarcodeEntity = new EntityInsertionAdapter<BarcodeEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `barcode_history` (`barcode`,`title`,`image_url`,`favourite`) VALUES (?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, BarcodeEntity value) {
        if (value.getBarcode() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getBarcode());
        }
        if (value.getTitle() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTitle());
        }
        if (value.getImageUrl() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getImageUrl());
        }
        final int _tmp = value.isFavourite() ? 1 : 0;
        stmt.bindLong(4, _tmp);
      }
    };
    this.__deletionAdapterOfBarcodeEntity = new EntityDeletionOrUpdateAdapter<BarcodeEntity>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `barcode_history` WHERE `barcode` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, BarcodeEntity value) {
        if (value.getBarcode() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindString(1, value.getBarcode());
        }
      }
    };
  }

  @Override
  public void insert(final BarcodeEntity barcode) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfBarcodeEntity.insert(barcode);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final BarcodeEntity barcode) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfBarcodeEntity.handle(barcode);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public Flow<List<BarcodeEntity>> getAll() {
    final String _sql = "SELECT * FROM barcode_history";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"barcode_history"}, new Callable<List<BarcodeEntity>>() {
      @Override
      public List<BarcodeEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfBarcode = CursorUtil.getColumnIndexOrThrow(_cursor, "barcode");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfImageUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "image_url");
          final int _cursorIndexOfIsFavourite = CursorUtil.getColumnIndexOrThrow(_cursor, "favourite");
          final List<BarcodeEntity> _result = new ArrayList<BarcodeEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final BarcodeEntity _item;
            final String _tmpBarcode;
            if (_cursor.isNull(_cursorIndexOfBarcode)) {
              _tmpBarcode = null;
            } else {
              _tmpBarcode = _cursor.getString(_cursorIndexOfBarcode);
            }
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpImageUrl;
            if (_cursor.isNull(_cursorIndexOfImageUrl)) {
              _tmpImageUrl = null;
            } else {
              _tmpImageUrl = _cursor.getString(_cursorIndexOfImageUrl);
            }
            final boolean _tmpIsFavourite;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsFavourite);
            _tmpIsFavourite = _tmp != 0;
            _item = new BarcodeEntity(_tmpBarcode,_tmpTitle,_tmpImageUrl,_tmpIsFavourite);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Flow<List<BarcodeEntity>> getFav() {
    final String _sql = "SELECT * FROM barcode_history WHERE favourite LIKE 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"barcode_history"}, new Callable<List<BarcodeEntity>>() {
      @Override
      public List<BarcodeEntity> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfBarcode = CursorUtil.getColumnIndexOrThrow(_cursor, "barcode");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfImageUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "image_url");
          final int _cursorIndexOfIsFavourite = CursorUtil.getColumnIndexOrThrow(_cursor, "favourite");
          final List<BarcodeEntity> _result = new ArrayList<BarcodeEntity>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final BarcodeEntity _item;
            final String _tmpBarcode;
            if (_cursor.isNull(_cursorIndexOfBarcode)) {
              _tmpBarcode = null;
            } else {
              _tmpBarcode = _cursor.getString(_cursorIndexOfBarcode);
            }
            final String _tmpTitle;
            if (_cursor.isNull(_cursorIndexOfTitle)) {
              _tmpTitle = null;
            } else {
              _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            }
            final String _tmpImageUrl;
            if (_cursor.isNull(_cursorIndexOfImageUrl)) {
              _tmpImageUrl = null;
            } else {
              _tmpImageUrl = _cursor.getString(_cursorIndexOfImageUrl);
            }
            final boolean _tmpIsFavourite;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsFavourite);
            _tmpIsFavourite = _tmp != 0;
            _item = new BarcodeEntity(_tmpBarcode,_tmpTitle,_tmpImageUrl,_tmpIsFavourite);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
