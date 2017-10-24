package fr.tse.applicationDistrib.Jtwig;

import org.jtwig.environment.EnvironmentConfigurationBuilder;
import org.jtwig.hot.reloading.HotReloadingExtension;
import org.jtwig.spring.JtwigViewResolver;
import org.jtwig.spring.asset.SpringAssetExtension;
import org.jtwig.spring.asset.resolver.AssetResolver;
import org.jtwig.spring.asset.resolver.BaseAssetResolver;
import org.jtwig.spring.boot.config.JtwigViewResolverConfigurer;
import org.jtwig.web.servlet.JtwigRenderer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class JtwigConfiguration implements JtwigViewResolverConfigurer {

    @Override
    public void configure(JtwigViewResolver viewResolver) {
        EnvironmentConfigurationBuilder configuration = EnvironmentConfigurationBuilder
                .configuration()
                .extensions()
                .add(new SpringAssetExtension())
                .add(new HotReloadingExtension())
                .and();
        JtwigRenderer renderer = new JtwigRenderer(configuration.build());
        viewResolver.setRenderer(renderer);
    }

    @Bean
    public AssetResolver assetResolver() {
        BaseAssetResolver assetResolver = new BaseAssetResolver();
        assetResolver.setPrefix("/public");
        return assetResolver;
    }
}


