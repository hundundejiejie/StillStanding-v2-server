package com.zaca.stillstanding.domain.buff;
/**
 * @author hundun
 * Created on 2020/05/20
 */
public abstract class BuffEffect {
    
    private BuffEffectType type;
    
    public BuffEffect(BuffEffectType type) {
        this.type = type;
    }
    
    public BuffEffectType getType() {
        return type;
    }

}
