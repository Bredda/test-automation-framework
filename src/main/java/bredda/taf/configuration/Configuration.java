package bredda.taf.configuration;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:environments/default.properties",
        "classpath:file:environments/${environment}.properties"})
public interface Configuration extends Config {

    @Key("scan.package")
    @DefaultValue("")
    String scanPackage();

    @Key("web.base.url")
    @DefaultValue("")
    String webBaseUrl();

    @Key("rest.base.url")
    @DefaultValue("")
    String restBaseUrl();

    @Key("rest.base.port")
    @DefaultValue("")
    int restBasePort();

    @Key("browser")
    @DefaultValue("chrome")
    String browser();

    @Key("target")
    @DefaultValue("local")
    String target();

    @Key("web.default.timeout")
    @DefaultValue("10")
    int webDefaultTimeout();

    @Key("grid.url")
    String gridUrl();

    @Key("grid.port")
    String gridPort();

    @Key("faker.locale")
    String faker();

    @Key("headless")
    @DefaultValue("false")
    Boolean headless();

    @Key("report.path")
    @DefaultValue("target/site/taf")
    String reportPath();

    @Key("report.format")
    @DefaultValue("progress,html,json")
    String reportFormat();

    @Key("user.dir")
    String userDir();

    @Key("os.name")
    @DefaultValue("")
    String os();

    @Key("environment")
    @DefaultValue("")
    String environment();
}
