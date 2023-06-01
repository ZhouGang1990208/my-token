package cn.dev33.satoken.config;

import java.io.Serializable;

/**
 * 路由配置
 * <p>
 * 搭配配置中心使用 @EnableDynamicRouter 实现动态路由
 *
 * @author einsitang
 */
public class SaRouterConfig implements Serializable {


  private static final long serialVersionUID = 6457701626541613685L;

  /**
   * Enable
   */
  private Boolean enable;

  /**
   * 路由规则
   */
  private SaRouterRule[] rules;

  public Boolean getEnable() {
    return enable;
  }

  public void setEnable(Boolean enable) {
    this.enable = enable;
  }

  public SaRouterRule[] getRules() {
    return this.rules;
  }

  public void setRules(SaRouterRule[] rules) {
    this.rules = rules;
  }

}
