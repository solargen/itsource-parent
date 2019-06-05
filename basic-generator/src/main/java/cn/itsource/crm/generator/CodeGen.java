package cn.itsource.crm.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.*;

/**
 * @author solargen
 * @version V1.0
 * @className CodeGen
 * @description TODO
 * @date 2019/5/16
 */
public class CodeGen {

    public static void main(String[] args) {

        //用来获取Mybatis-Plus.properties文件的配置信息
        final ResourceBundle rb = ResourceBundle.getBundle("itsource-generator");
        AutoGenerator mpg = new AutoGenerator();
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setFileOverride(true);//是否重写
        gc.setActiveRecord(true);// 开启 activeRecord 模式
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(false);// XML columList
        gc.setAuthor(rb.getString("author"));
        mpg.setGlobalConfig(gc);
        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setTypeConvert(new MySqlTypeConvert());
        dsc.setDriverName(rb.getString("jdbc.driver"));
        dsc.setUsername(rb.getString("jdbc.user"));
        dsc.setPassword(rb.getString("jdbc.pwd"));
        dsc.setUrl(rb.getString("jdbc.url"));
        mpg.setDataSource(dsc);
        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setTablePrefix(new String[] { "t_" });// 此处可以修改为您的表前缀
        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
        strategy.setInclude(new String[]{"t_menu"}); // 需要生成的表
        mpg.setStrategy(strategy);
        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent(rb.getString("parent"));
        pc.setController("controller");
        pc.setService("service");
        pc.setServiceImpl("service.impl");
        pc.setMapper("mapper");
        pc.setEntity("domain");
        mpg.setPackageInfo(pc);

        // 注入自定义配置，可以在 VM 中使用 cfg.abc 【可无】
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
            }
        };

        List<FileOutConfig> focList = new ArrayList<FileOutConfig>();

        // 调整 controller 生成目录演示
        focList.add(new FileOutConfig("/templates/controller.java.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return rb.getString("ProductPath")+ "/itsource-web/src/main/java/cn/itsource/crm/controller/" + tableInfo.getEntityName() + "Controller.java";
            }
        });

        // 调整 service 生成目录演示
        focList.add(new FileOutConfig("/templates/service.java.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return rb.getString("ProductPath")+ "/itsource-service/src/main/java/cn/itsource/crm/service/" + "I" + tableInfo.getEntityName() + "Service.java";
            }
        });

        // 调整 serviceImpl 生成目录演示
        focList.add(new FileOutConfig("/templates/serviceImpl.java.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return rb.getString("ProductPath")+ "/itsource-service/src/main/java/cn/itsource/crm/service/impl/" + tableInfo.getEntityName() + "ServiceImpl.java";
            }
        });

        // 调整 mapper 生成目录演示
        focList.add(new FileOutConfig("/templates/mapper.java.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return rb.getString("ProductPath")+ "/itsource-mapper/src/main/java/cn/itsource/crm/mapper/" + tableInfo.getEntityName() + "Mapper.java";
            }
        });

        // 调整 xml 生成目录演示
        focList.add(new FileOutConfig("/templates/mapper.xml.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return rb.getString("ProductPath")+ "/itsource-mapper/src/main/resources/cn/itsource/crm/mapper/" + tableInfo.getEntityName() + "Mapper.xml";
            }
        });

        // 调整 query 生成目录演示
        focList.add(new FileOutConfig("/templates/query.java.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return rb.getString("ProductPath")+ "/itsource-common/src/main/java/cn/itsource/crm/query/" + tableInfo.getEntityName() + "Query.java";
            }
        });

        // 调整 domain 生成目录演示
        focList.add(new FileOutConfig("/templates/entity.java.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return rb.getString("ProductPath")+ "/itsource-common/src/main/java/cn/itsource/crm/domain/" + tableInfo.getEntityName() + ".java";
            }
        });

        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 自定义模板配置，可以 copy 源码 mybatis-plus/src/main/resources/templates 下面内容修改，
        // 放置自己项目的 src/main/resources/templates 目录下, 默认名称一下可以不配置，也可以自定义模板名称
        TemplateConfig tc = new TemplateConfig();
        // 如上任何一个模块如果设置 空 OR Null 将不生成该模块。
        tc.setEntity(null);
        tc.setController(null);
        tc.setService(null);
        tc.setServiceImpl(null);
        tc.setMapper(null);
        tc.setXml(null);
        mpg.setTemplate(tc);


        // 执行生成
        mpg.execute();


    }

}
