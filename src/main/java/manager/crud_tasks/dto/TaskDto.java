package manager.crud_tasks.dto;

import lombok.Data;

@Data
public class TaskDto {
    private Long id;
    private String titulo;
    private String descricao;
    private enum status { Pendente, Em_Andamento, Completado};
}
