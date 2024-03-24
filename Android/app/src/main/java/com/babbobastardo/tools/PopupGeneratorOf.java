package com.ingsw.dietiDeals24.ui.utility;

import static java.lang.Thread.sleep;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;

import androidx.fragment.app.Fragment;

import com.babbobastardo.model.Gifter;
import com.saadahmedsoft.popupdialog.PopupDialog;
import com.saadahmedsoft.popupdialog.Styles;
import com.saadahmedsoft.popupdialog.listener.OnDialogButtonClickListener;

import com.babbobastardo.R;

import java.util.concurrent.ExecutionException;

public class PopupGeneratorOf {

    public static PopupDialog loadingPopup(Context context) {
        PopupDialog loadingPopup = PopupDialog.getInstance(context);
        loadingPopup.setStyle(Styles.PROGRESS)
                .setProgressDialogTint(context.getColor(R.color.colorPrimary))
                .setCancelable(false)
                .showDialog();
        return loadingPopup;
    }

    public static void errorPopup(Context context, String message) {
        PopupDialog.getInstance(context)
                .setStyle(Styles.FAILED)
                .setHeading("Riprova!")
                .setDescription(message)
                .setCancelable(false)
                .setDismissButtonText("Chiudi")
                .showDialog(new OnDialogButtonClickListener() {
                    @Override
                    public void onDismissClicked(Dialog dialog) {
                        super.onDismissClicked(dialog);
                    }
                });
    }


    public static void connectionAbsentPopup(Context context) {

        PopupDialog.getInstance(context)
                .setStyle(Styles.FAILED)
                .setHeading("Riprova!")
                .setDescription("Connessione assente. Controlla la tua connessione e riprova.")
                .setCancelable(false)
                .setDismissButtonText("Chiudi")
                .showDialog(new OnDialogButtonClickListener() {
                    @Override
                    public void onDismissClicked(Dialog dialog) {
                        super.onDismissClicked(dialog);
                    }
                });
    }


    public static void successPopup(Context context, String message) {
        PopupDialog.getInstance(context)
                .setStyle(Styles.SUCCESS)
                .setHeading("Finito!")
                .setDescription(message)
                .setCancelable(false)
                .setDismissButtonText("Chiudi")
                .showDialog(new OnDialogButtonClickListener() {
                    @Override
                    public void onDismissClicked(Dialog dialog) {
                        super.onDismissClicked(dialog);
                    }
                });
    }


    public static void areYouSureToDeleteGifterPopup(Fragment fragment, Gifter gifter) {
        PopupDialog.getInstance(fragment.getContext())
                .setStyle(Styles.STANDARD)
                .setHeading("Rimuovere il partecipante?")
                .setDescription("Sei sicuro di voler rimuovere " + gifter.getName() +
                        " dal babbo natale segreto?")
                .setPopupDialogIcon(R.drawable.delete_ic)
                .setPopupDialogIconTint(R.color.red)
                .setCancelable(false)
                .setPositiveButtonText("Sì, l'ha trollata")
                .setNegativeButtonText("Annulla")
                .showDialog(new OnDialogButtonClickListener() {
                    @Override
                    public void onPositiveClicked(Dialog dialog) {
                        super.onPositiveClicked(dialog);
                        deleteLink(fragment, gifter);
                    }

                    @Override
                    public void onNegativeClicked(Dialog dialog) {
                        super.onNegativeClicked(dialog);
                    }
                });
    }

    private static void deleteLink(Fragment fragment, Gifter gifter) {
        PopupDialog loading = PopupGeneratorOf.loadingPopup(fragment.getContext());
        new Thread(() -> {
            try {
                ProfileController.deleteLink(gifter).get();
                sleep(500);
                fragment.requireActivity().runOnUiThread(() -> ToastManager.showToast(fragment.getContext(), fragment.getString(R.string.link_deleted)));
                fragment.getParentFragmentManager().beginTransaction().replace(R.id.fragment_container_home,
                        new EditExternalLinksFragment()).commit();
            } catch (ExecutionException e) {
                fragment.requireActivity().runOnUiThread(() -> PopupGeneratorOf.errorPopup(fragment.getContext(), e.getCause().getMessage()));
            } catch (InterruptedException e) {
                fragment.requireActivity().runOnUiThread(() -> PopupGeneratorOf.errorPopup(fragment.getContext(), "Operazione interrotta, riprovare"));
            } finally {
                fragment.requireActivity().runOnUiThread(loading::dismissDialog);
            }
        }).start();
    }


    public static void areYouSureToAcceptBidPopup(Context context) {
        PopupDialog.getInstance(context)
                .setStyle(Styles.STANDARD)
                .setHeading("Accettare l'offerta?")
                .setDescription("Sei sicuro di voler accettare l'offerta? L'asta finirà e non potrai più ricevere altre offerte.")
                .setPopupDialogIcon(R.drawable.ic_check_circle)
                .setPopupDialogIconTint(R.color.green)
                .setCancelable(false)
                .setPositiveButtonText("Conferma")
                .setNegativeButtonText("Annulla")
                .showDialog(new OnDialogButtonClickListener() {
                    @Override
                    public void onPositiveClicked(Dialog dialog) {
                        super.onPositiveClicked(dialog);
                        //TODO: accept bid
                    }

                    @Override
                    public void onNegativeClicked(Dialog dialog) {
                        super.onNegativeClicked(dialog);
                    }
                });
    }
}
