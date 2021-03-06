package hundun.quizgame.core.model.role;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import hundun.quizgame.core.dto.role.RoleConstInfoDTO;
import hundun.quizgame.core.exception.QuizgameException;
import hundun.quizgame.core.model.skill.SkillConstData;
import hundun.quizgame.core.model.skill.SkillSlot;

/**
 * @author hundun
 * Created on 2019/10/08
 */
public class RolePrototype {
    
    private final String name;
    private final String description;
    private List<SkillSlot> skillSlots;
    
    
    public RolePrototype(String name, String description, SkillSlot... skillSlots) {
        this.name = name;
        this.description = description;
        this.skillSlots = Arrays.asList(skillSlots);
    }
    
    public String getName() {
        return name;
    }
    
    public String getDescription() {
        return description;
    }
    
    public List<SkillSlot> getSkillSlots() {
        return skillSlots;
    }
    
    public SkillConstData getSkill(String skillName) throws QuizgameException {
        
        for (SkillSlot skillSlot : this.getSkillSlots()) {
            if (skillSlot.getSkill().getName().equals(skillName)) {
                return skillSlot.getSkill();
            }
        }
        throw new QuizgameException(this.getName() + "里没有技能：" + skillName, -1);
    }
    
    
    public RoleConstInfoDTO toRoleConstInfoDTO() {
        RoleConstInfoDTO dto = new RoleConstInfoDTO();
        dto.setName(this.getName());
        dto.setDescription(this.getDescription());
        List<String> skillNames = new ArrayList<>(this.getSkillSlots().size());
        List<String> skillDescriptions = new ArrayList<>(this.getSkillSlots().size());
        List<Integer> skillFullCounts = new ArrayList<>(this.getSkillSlots().size());
        for (SkillSlot skillSlot : this.getSkillSlots()) {
            skillNames.add(skillSlot.getSkill().getName());
            skillDescriptions.add(skillSlot.getSkill().getDescription());
            skillFullCounts.add(skillSlot.getFullCount());
        }
        dto.setSkillNames(skillNames);
        dto.setSkillDescriptions(skillDescriptions);
        dto.setSkillFullCounts(skillFullCounts);
        return dto;
    }


}
