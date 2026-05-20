package io.github.mfaisalkhatri.config;

import java.io.InputStream;

import io.github.mfaisalkhatri.model.FrameworkConfig;
import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;
import org.yaml.snakeyaml.error.YAMLException;

public class YamlConfigSource implements ConfigSource {

    private static final String CONFIG_FILE = "config.yaml";

    @Override
    public FrameworkConfig loadConfig () {
        final LoaderOptions loaderOptions = new LoaderOptions ();
        final Yaml yaml = new Yaml (new Constructor (FrameworkConfig.class, loaderOptions));
        try (
            final InputStream inputStream = getClass ().getClassLoader ()
                .getResourceAsStream (CONFIG_FILE)) {

            if (inputStream == null) {
                throw new IllegalArgumentException (CONFIG_FILE + " file not found in the resources directory!");
            }
            final FrameworkConfig config = yaml.load (inputStream);
            if (config == null) {
                throw new IllegalStateException ("Failed to load configuration from " + CONFIG_FILE);
            }

            return config;
        } catch (final YAMLException e) {
            throw new IllegalStateException ("Invalid YAML configuration in " + CONFIG_FILE, e);
        } catch (final Exception exception) {
            throw new IllegalStateException ("Error while loading configuration from " + CONFIG_FILE, exception);
        }
    }
}