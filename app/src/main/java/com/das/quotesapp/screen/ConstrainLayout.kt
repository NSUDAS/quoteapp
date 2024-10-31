package com.das.quotesapp.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.das.quotesapp.R

/**
 * Created by S N Shekhar Das on 31/10/24.
 *
 */

@Preview(showBackground = true, device = "id:pixel_5")
@Composable
fun SocialMediaPost() {

    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)
    ) {
        val (avatar, name, username, moreOptions, image, like, comment, share, bookmark, likes, caption, comments, time) = createRefs()

        //image

        Image(painter = painterResource(id = R.drawable.face), contentDescription = null,
            modifier = Modifier
                .padding(start = 16.dp)
                .size(44.dp)
                .clip(CircleShape)
                .constrainAs(avatar) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                })

        //name
        Text(
            text = "First Name & Last Name",
            style = MaterialTheme.typography.titleSmall,
            modifier = Modifier.constrainAs(name) {
                top.linkTo(parent.top, margin = 3.dp)
                start.linkTo(avatar.end, margin = 8.dp)
            }
        )

        //username
        Text(
            text = "User Name",
            style = MaterialTheme.typography.titleSmall,
            modifier = Modifier.constrainAs(username) {
                top.linkTo(name.bottom, margin = 3.dp)
                start.linkTo(avatar.end, margin = 8.dp)
            }
        )

        //icon
        IconButton(
            onClick = {
            }, modifier = Modifier
                .padding(end = 16.dp)
                .size(24.dp)
                .constrainAs(moreOptions) {
                    top.linkTo(avatar.top)
                    bottom.linkTo(avatar.bottom)
                    end.linkTo(parent.end)
                }
        ) {
            Icon(
                painter = painterResource(androidx.core.R.drawable.ic_call_answer),
                contentDescription = null
            )

        }

        Image(painter = painterResource(id = R.drawable.face), contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .constrainAs(image) {
                    top.linkTo(avatar.bottom, margin = 16.dp)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
        )

        Icon(
            painter = painterResource(androidx.core.R.drawable.ic_call_answer),
            contentDescription = null,
            modifier = Modifier
                .height(24.dp)
                .constrainAs(like) {
                    top.linkTo(image.bottom, margin = 16.dp)
                    start.linkTo(parent.start, margin = 16.dp)
                }
        )

        Icon(
            painter = painterResource(androidx.core.R.drawable.ic_call_answer),
            contentDescription = null,
            modifier = Modifier
                .height(24.dp)
                .constrainAs(comment) {
                    top.linkTo(image.bottom, margin = 16.dp)
                    start.linkTo(like.end, margin = 16.dp)
                }
        )

        Icon(
            painter = painterResource(androidx.core.R.drawable.ic_call_answer),
            contentDescription = null,
            modifier = Modifier
                .height(24.dp)
                .constrainAs(share) {
                    top.linkTo(image.bottom, margin = 16.dp)
                    start.linkTo(comment.end, margin = 16.dp)
                }
        )

        Icon(
            painter = painterResource(androidx.core.R.drawable.ic_call_answer),
            contentDescription = null,
            modifier = Modifier
                .height(24.dp)
                .constrainAs(bookmark) {
                    top.linkTo(image.bottom, margin = 16.dp)
                    end.linkTo(parent.end, margin = 16.dp)
                }
        )

        Text(
            text = "128 Likes",
            style = MaterialTheme.typography.titleSmall,
            color = Color.Gray,
            modifier = Modifier.constrainAs(likes) {
                top.linkTo(like.bottom, margin = 8.dp)
                start.linkTo(parent.start, margin = 16.dp)
            }
        )

        Text(
            text = "This is the caption of the post",
            style = MaterialTheme.typography.titleSmall,
            modifier = Modifier.constrainAs(caption) {
                top.linkTo(likes.bottom, margin = 4.dp)
                start.linkTo(parent.start, margin = 16.dp)
            }
        )

        Text(
            text = "View all of 13 comments",
            style = MaterialTheme.typography.titleSmall,
            color = Color.Gray,
            modifier = Modifier.constrainAs(comments) {
                top.linkTo(caption.bottom, margin = 3.dp)
                start.linkTo(parent.start, margin = 16.dp)
            }
        )

        Text(
            text = "2 Hours aga",
            style = MaterialTheme.typography.titleSmall,
            color = Color.Gray,
            modifier = Modifier.constrainAs(time) {
                top.linkTo(comments.bottom, margin = 3.dp)
                start.linkTo(parent.start, margin = 16.dp)
            }
        )


    }
}

@Preview(showBackground = true, device = "id:pixel_5")
@Composable
fun CellDesign() {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp)
    ) {
        val (avatar, name, username, moreOptions) = createRefs()

        //image

        Image(painter = painterResource(id = R.drawable.face), contentDescription = null,
            modifier = Modifier
                .padding(start = 16.dp)
                .size(44.dp)
                .clip(CircleShape)
                .constrainAs(avatar) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                })

        //name
        Text(
            text = "First Name & Last Name",
            style = MaterialTheme.typography.labelLarge,
            color = Color.Magenta,
            modifier = Modifier.constrainAs(name) {
                top.linkTo(parent.top, margin = 3.dp)
                start.linkTo(avatar.end, margin = 8.dp)
            }
        )

        //username
        Text(
            text = "User Name",
            style = MaterialTheme.typography.titleSmall,
            modifier = Modifier.constrainAs(username) {
                top.linkTo(name.bottom, margin = 3.dp)
                start.linkTo(avatar.end, margin = 8.dp)
            }
        )

        //icon
        IconButton(
            onClick = {
            }, modifier = Modifier
                .padding(end = 16.dp)
                .size(24.dp)
                .constrainAs(moreOptions) {
                    top.linkTo(avatar.top)
                    bottom.linkTo(avatar.bottom)
                    end.linkTo(parent.end)
                }
        ) {
            Icon(
                painter = painterResource(androidx.core.R.drawable.ic_call_answer),
                contentDescription = null
            )

        }
    }
}