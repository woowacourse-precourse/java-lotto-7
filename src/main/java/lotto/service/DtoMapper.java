package lotto.service;

public interface DtoMapper <Entity,Dto> {
    Dto toDto(Entity entity);
}
