package com.cozycats.Setting;

import com.cozycats.cozycatscommon.entity.Setting;
import com.cozycats.cozycatscommon.entity.SettingCategory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SettingRepository extends CrudRepository<Setting, String> {

    public List<Setting> findByCategory(SettingCategory category);

    @Query("select  s from Setting s where s.category = ?1 or s.category = ?2")
    public List<Setting> findByTwoCategories(SettingCategory catOne, SettingCategory catTwo);
}