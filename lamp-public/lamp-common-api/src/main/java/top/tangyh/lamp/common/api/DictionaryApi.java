package top.tangyh.lamp.common.api;

import top.tangyh.basic.interfaces.echo.LoadService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.tangyh.lamp.common.api.fallback.DictionaryApiFallback;

import java.io.Serializable;
import java.util.Map;
import java.util.Set;

/**
 * 数据字典API
 *
 * @author zuihou
 * @date 2019/07/26
 */
@FeignClient(name = "${lamp.feign.oauth-server:lamp-oauth-server}", path = "dictionary", fallback = DictionaryApiFallback.class)
public interface DictionaryApi extends LoadService {

    /**
     * 根据id查询实体
     *
     * @param ids 唯一键（可能不是主键ID)
     * @return
     */
    @Override
    @GetMapping("/findByIds")
    Map<Serializable, Object> findByIds(@RequestParam(value = "ids") Set<Serializable> ids);

}
