package lotto.service.mapper;

public interface DtoMapper <Entity,Dto> {
    Dto toDto(Entity entity);
}
