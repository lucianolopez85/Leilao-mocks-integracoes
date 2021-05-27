package br.com.alura.leilao.ui.recyclerview.adapter;

import android.content.Context;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;

import br.com.alura.leilao.model.Leilao;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ListaLeilaoAdapterTest {

    @Test
    public void deve_AtualizarListaDeLeiloes_QuandoReceberListaDeLeiloes(){
        Context context = Mockito.mock(Context.class);
        ListaLeilaoAdapter adapter = Mockito.spy(new ListaLeilaoAdapter(context));
        Mockito.doNothing().when(adapter).atualizaLista();

        adapter.atualiza(new ArrayList<Leilao>(Arrays.asList(
                new Leilao("SSD"),
                new Leilao("HD")
        )));
        int quantidadeLeiloesDevolvida = adapter.getItemCount();

        Mockito.verify(adapter).atualizaLista();
        assertThat(quantidadeLeiloesDevolvida, is(2));
    }

}